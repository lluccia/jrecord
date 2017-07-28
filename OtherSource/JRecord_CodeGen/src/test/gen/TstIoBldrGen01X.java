package test.gen;

import net.sf.JRecord.cg.Generate;
import net.sf.JRecord.cg.details.ArgumentOption;

public class TstIoBldrGen01X {

	public static void main(String[] args) {

		String[] arguments1 = {
				ArgumentOption.OPT_TEMPLATE, "basicX",
				ArgumentOption.OPT_TEMPLATE_DIRECTORY, "G:\\Temp\\Gen\\TemplateSource",
				ArgumentOption.OPT_SCHEMA, TstIoBldrGen01X.class.getResource("DTAR020.cbl").getFile(),
				ArgumentOption.OPT_FILE_ORGANISATION, "FixedWidth",
				ArgumentOption.OPT_FONT_NAME, "CP037",
				ArgumentOption.OPT_DROP_COPYBOOK_NAME, "true",
				ArgumentOption.OPT_OUTPUT_DIR, "G:/Temp/Gen/ioBuilderX"
		};
		
		Generate.main(arguments1);

//		String[] arguments2 = {
//				ArgumentOption.OPT_TEMPLATE, "basic",
//				ArgumentOption.OPT_SCHEMA, TstIoBldrGen01X.class.getResource("ams_PO_Download.Xml").getFile(),
//				ArgumentOption.OPT_OUTPUT_DIR, "G:/Temp/Gen/ioBuilder"
//		};
//		
//		Generate.main(arguments2);
//
//		
//		String[] arguments3 = {
//				ArgumentOption.OPT_TEMPLATE, "basic",
//				ArgumentOption.OPT_SCHEMA, TstIoBldrGen01X.class.getResource("MultiRecordTest.cbl").getFile(),
//				ArgumentOption.OPT_FILE_ORGANISATION, "FixedWidth",
//				ArgumentOption.OPT_SPLIT, "01",
//				ArgumentOption.OPT_OUTPUT_DIR, "G:/Temp/Gen/ioBuilder"
//		};
//		
//		Generate.main(arguments3);
	}

}
