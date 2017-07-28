package net.sf.JRecord.test.schema.cobol.gen.data;

 /*
  * *------------- Keep this notice in your final code ---------------
  * *   This code was generated by JRecord projects CodeGen program
  * *            on the: 11 Jul 2016 10:17:9 
  * *     from Copybook: JR_Schema_Test.cbl
  * *          Template: lineWrapper
  * *             Split: 01   
  * * File Organization: 0   
  * *              Font: 
  * *   
  * *    CodeGen Author: Bruce Martin
  * *-----------------------------------------------------------------
  *
  *   This Code should not be changed you should, either:
  *   * Rerun CodeGen to regenerate it 
  *   * Fix CodeGen and rerun CodeGen
  *
  *   Please supply any program fixes/enhancements/documentation
  *   back to the JRecord project (https://sourceforge.net/projects/jrecord/)
  *   so other people can benefit !!!
  * 
  *
  *          Bruce Martin (JRecord / CodeGen Author) 
  *
  * ------------------------------------------------------------------
  * v01  CodeGen        11 Jul 2016  Initial version
  *     (Bruce Martin)
  */


import net.sf.JRecord.Details.AbstractLine;
import net.sf.JRecord.Details.IGetByteData;
import net.sf.JRecord.Details.Line;

public class LineFieldRecordJR implements IGetByteData {
    
    private AbstractLine line; 

    private static FieldNamesJrSchemaTest.RecordFieldRecord fn
                   = FieldNamesJrSchemaTest.RECORD_FIELD_RECORD;

        

    public short getRecordType() {
        return (short) line.getFieldValue(fn.recordType).asInt();                                 
    }
    
    public void setRecordType(short value) {
        this.line.getFieldValue(fn.recordType).set(value);
    }

    public String getFieldName() {
        return line.getFieldValue(fn.fieldName).asString();
    }
    
    public void setFieldName(String value) {
        this.line.getFieldValue(fn.fieldName).set(value);
    }

    public short getFieldType() {
        return (short) line.getFieldValue(fn.fieldType).asInt();                                 
    }
    
    public void setFieldType(short value) {
        this.line.getFieldValue(fn.fieldType).set(value);
    }

    public int getFieldPosition() {
        return line.getFieldValue(fn.fieldPosition).asInt();                                 
    }
    
    public void setFieldPosition(int value) {
        this.line.getFieldValue(fn.fieldPosition).set(value);
    }

    public int getFieldLength() {
        return  line.getFieldValue(fn.fieldLength).asInt();                                 
    }
    
    public void setFieldLength(int value) {
        this.line.getFieldValue(fn.fieldLength).set(value);
    }

    public short getDecimal() {
        return (short) line.getFieldValue(fn.decimal).asInt();                                 
    }
    
    public void setDecimal(short value) {
        this.line.getFieldValue(fn.decimal).set(value);
    }


	


    @Override
    public byte[] getData() {
        return line.getData();  
    }

    @Override
    public void setData(byte[] data) {

        if (line instanceof Line) {
            ((Line) line).setData(data);
        } else {
            throw new RuntimeException("Invalid line for setdata");
        }
    }
    
    public LineFieldRecordJR setLine(AbstractLine l) {
    	line = l;
    	return this;
    }
    
    public AbstractLine getLine() {
        return line;
    }
}

