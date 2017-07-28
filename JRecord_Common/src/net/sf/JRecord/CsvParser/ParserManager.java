/*
 * This class maanges the various line parsers
 */
/*  -------------------------------------------------------------------------
 *
 *            Sub-Project: JRecord Common
 *    
 *    Sub-Project purpose: Common Low-Level Code shared between 
 *                        the JRecord and Record Projects
 *    
 *                 Author: Bruce Martin
 *    
 *                License: LGPL 2.1 or latter
 *                
 *    Copyright (c) 2016, Bruce Martin, All Rights Reserved.
 *   
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *   
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 * ------------------------------------------------------------------------ */
      
package net.sf.JRecord.CsvParser;

import net.sf.JRecord.Common.BasicNamedManager;

/**
 * Class to manage the various CSV Line parsers
 *
 * @author Bruce Martin
 */
public class ParserManager extends BasicNamedManager<ICsvLineParser> {
	private static boolean useNewCsvParsers = true;

	public static final int BASIC_CSV_PARSER_NEW_NUM = 14;
	public static final int BASIC_PARSER_QUOTE_BY_TYPE = 15;

	public static  int BASIC_CSV_PARSER = 0;
	public static  int EXTENDED_BASIC_CSV_PARSER = BASIC_CSV_PARSER_NEW_NUM;
//	public static final int BASIC_CSV_PARSER = 12;
	public static final int STANDARD_CSV_PARSER = 1;
	public static final int DB_CSV_PARSER = 2;
	public static final int BASIC_QUOTED_COL_NAME_CSV_PARSER = 3;
	public static final int STANDARD_QUOTED_COL_NAME_CSV_PARSER = 4;
	public static final int DB_QUOTED_COL_NAME_CSV_PARSER = 5;
	public static final int BASIC_ENSURE_CORRECT_NO_FIELDS = 6;
	public static final int BASIC_ENSURE_CORRECT_NO_FIELDS_P1 = 7;
	public static final int BASIC_EMBEDDED_CR = 8;
	public static final int STANDARD_EMBEDDED_CR = 9;
	public static final int BASIC_EMBEDDED_CR_NAMES_IN_QUOTES = 10;
	public static final int STANDARD_EMBEDDED_CR_NAMES_INQUOTE = 11;
	public static final int STANDARD_EMBEDDED_CR_NAMES_TXT_INQUOTE = 12;
	public static final int BASIC_TXT_INQUOTE = 13;

	private static final int NUMBER_OF_PARSERS = 50;
	private static ParserManager instance = null;

//	private Parser[] list = new Parser[NUMBER_OF_PARSERS];
//	private String[] names = new String[NUMBER_OF_PARSERS];


	/**
	 * Manage the various line parsers
	 *
	 */
	public ParserManager() {
		this(true);
	}

	public ParserManager(boolean newformat) {
		super("Csv_Parsers", NUMBER_OF_PARSERS, NUMBER_OF_PARSERS, new ICsvLineParser[NUMBER_OF_PARSERS]);
		
		setUseNewCsvParsers(newformat);
		if (newformat) {
			defineNewParsers();
		} else {
			defineOldParsers();
		}
	}
	
	private void defineOldParsers() {
		
		register(BASIC_CSV_PARSER, "Basic Parser", BasicCsvLineParser.getInstance());
		register(STANDARD_CSV_PARSER, "Parser - Matching Quotes", new StandardCsvLineParser());
		register(DB_CSV_PARSER, "Parser - Quotes based on field Type", new StandardCsvLineParser(true));
		register(BASIC_QUOTED_COL_NAME_CSV_PARSER, "Basic Parser Column names in quotes", new BasicCsvLineParser(true));
		register(STANDARD_QUOTED_COL_NAME_CSV_PARSER, "Parser - Matching Quotes Column names in quotes",
				new StandardCsvLineParser(false, true));
		register(DB_QUOTED_COL_NAME_CSV_PARSER, "Parser - Quotes based on field Type, Column names in quotes",
				new StandardCsvLineParser(true, true));
		register(BASIC_ENSURE_CORRECT_NO_FIELDS,    "Basic - Delimiter all fields",     new BasicCsvLineParser(false, ICsvDefinition.SEP_FOR_EVERY_FIELD));
		register(BASIC_ENSURE_CORRECT_NO_FIELDS_P1, "Basic - Delimiter all fields + 1", new BasicCsvLineParser(false, ICsvDefinition.SEP_FOR_EVERY_FIELD_PLUS_END));
		register(BASIC_EMBEDDED_CR,    "Basic - Embedded Cr",  new BasicCsvLineParser(false, ICsvDefinition.NORMAL_SPLIT, true, false));
		register(STANDARD_EMBEDDED_CR, "Standard - Embedded Cr",  new StandardCsvLineParser(false, true, true));

		register(BASIC_EMBEDDED_CR_NAMES_IN_QUOTES,    "Basic - Embedded Cr Column names in quotes",  new BasicCsvLineParser(true, ICsvDefinition.NORMAL_SPLIT, true, false));
		register(STANDARD_EMBEDDED_CR_NAMES_INQUOTE, "Standard - Embedded Cr Column names in quotes",  new StandardCsvLineParser(false, true, true));
		register(STANDARD_EMBEDDED_CR_NAMES_TXT_INQUOTE, "Std - Embedded Cr Col names/Txt Fields in quotes",  new StandardCsvLineParser(true, true, true));
		register(BASIC_CSV_PARSER_NEW_NUM, "Extended Basic Parser", BasicCsvLineParserExtended.getInstance());
	}

	private void defineNewParsers() {
		
		register(EXTENDED_BASIC_CSV_PARSER, "Extended Basic Parser", BasicCsvLineParserExtended.getInstance());
		register(STANDARD_CSV_PARSER, "Parser - Matching Quotes", new StandardCsvLineParser());
		register(DB_CSV_PARSER, "Parser - Quotes based on field Type", new BasicCsvLineParserExtended(false, ICsvDefinition.NORMAL_SPLIT, false, true));
		register(BASIC_QUOTED_COL_NAME_CSV_PARSER, "X-Basic Parser Column names in quotes", new BasicCsvLineParserExtended(true));
		register(STANDARD_QUOTED_COL_NAME_CSV_PARSER, "Parser - Matching Quotes Column names in quotes",
				new StandardCsvLineParser(false, true));
		register(DB_QUOTED_COL_NAME_CSV_PARSER, "Parser - Quotes based on field Type, Column names in quotes",
				new StandardCsvLineParser(true, true));
		register(BASIC_ENSURE_CORRECT_NO_FIELDS,    "X-Basic - Delimiter all fields",     new BasicCsvLineParserExtended(false, ICsvDefinition.SEP_FOR_EVERY_FIELD));
		register(BASIC_ENSURE_CORRECT_NO_FIELDS_P1, "X-Basic - Delimiter all fields + 1", new BasicCsvLineParserExtended(false, ICsvDefinition.SEP_FOR_EVERY_FIELD_PLUS_END));
		register(BASIC_EMBEDDED_CR,    "X-Basic - Embedded Cr",  new BasicCsvLineParserExtended(false, ICsvDefinition.NORMAL_SPLIT, true, false));
		register(STANDARD_EMBEDDED_CR, "Standard - Embedded Cr",  new StandardCsvLineParser(false, true, true));

		register(BASIC_EMBEDDED_CR_NAMES_IN_QUOTES,    "X-Basic - Embedded Cr Column names in quotes",  new BasicCsvLineParserExtended(true, ICsvDefinition.NORMAL_SPLIT, true, false));
		register(STANDARD_EMBEDDED_CR_NAMES_INQUOTE, "Standard - Embedded Cr Column names in quotes",  new StandardCsvLineParser(false, true, true));
		register(STANDARD_EMBEDDED_CR_NAMES_TXT_INQUOTE, "Std - Embedded Cr Col names/Txt Fields in quotes",  new StandardCsvLineParser(true, true, true));
		register(BASIC_TXT_INQUOTE,    "X-Basic - Text fields in quotes",     new BasicCsvLineParserExtended(false, ICsvDefinition.NORMAL_SPLIT, false, true));
		register(BASIC_CSV_PARSER_NEW_NUM, "Basic Parser", BasicCsvLineParser.getInstance());
		register(BASIC_PARSER_QUOTE_BY_TYPE, "Basic Parser - Quotes based on field Type", new StandardCsvLineParser(true));
	}

	/**
	 * get a ParserManager
	 * @return the instance
	 */
	public static ParserManager getInstance() {
		if (instance == null) {
			instance = new ParserManager(useNewCsvParsers);
		}
		return instance;
	}

	/**
	 * @see net.sf.JRecord.Common.BasicManager#get(int)
	 */
	@Override
	public ICsvLineParser get(int id) {
		if (id < 0 || id >= super.getNumberOfEntries()) {
			return super.get(0);
		}
		return super.get(id);
	}

	public static final boolean isUseNewCsvParsers() {
		return useNewCsvParsers;
	}

	public static final void setUseNewCsvParsers(boolean useNewCsvParsers) {
		ParserManager.useNewCsvParsers = useNewCsvParsers;
		
		BASIC_CSV_PARSER = 0;
		EXTENDED_BASIC_CSV_PARSER = BASIC_CSV_PARSER_NEW_NUM;
		if (useNewCsvParsers) {
			BASIC_CSV_PARSER = BASIC_CSV_PARSER_NEW_NUM;
			EXTENDED_BASIC_CSV_PARSER = 0;
		}
	}


}
