package com.ueh.common.util;

import java.util.Random;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class DocumentUtil {
	/*转PDF格式值*/
    private static final int wdFormatPDF = 17;
    private static final int xlFormatPDF = 0;
    private static final int ppFormatPDF = 32;
    private static final int msoTrue = -1;
    private static final int msofalse = 0;
    
    private static final int WORD_HTML = 8;  
    private static final int WORD_TXT = 7;  
    private static final int EXCEL_HTML = 44;  
    private static final int EXCEL_XML = 46;  
    private static final int EXCEL_43 = 43;
    private static final int EXCEL_2003 = 51;

	public static void wordToPdf(String inputFile,String pdfFile){ 
        //打开word应用程序 
       ActiveXComponent app = new ActiveXComponent("Word.Application"); 
        //设置word不可见，否则会弹出word界面 
       app.setProperty("Visible", false); 
        //获得word中所有打开的文档,返回Documents对象 
       Dispatch docs = app.getProperty("Documents").toDispatch(); 
        //调用Documents对象中Open方法打开文档，并返回打开的文档对象Document 
        Dispatch doc = Dispatch.call(docs, "Open", inputFile, false, true ).toDispatch(); 
        //调用Document对象的SaveAs方法，将文档保存为pdf格式 
       Dispatch.call(doc, "ExportAsFixedFormat",pdfFile, wdFormatPDF        //word保存为pdf格式 
               ); 
        //关闭文档 
       Dispatch.call(doc, "Close",false); 
        //关闭word应用程序 
       app.invoke("Quit", 0); 
    } 
	
		/**
		 * WORD转HTML
		 * 
		 * @param docfile
		 *            WORD文件全路径
		 * @param htmlfile
		 *            转换后HTML存放路径
		 */
		public static void wordToHtml(String docfile, String htmlfile) {
			// 初始化
			ComThread.InitSTA();
			ActiveXComponent app = new ActiveXComponent("Word.Application"); // 启动word
			try {
				app.setProperty("Visible", new Variant(false));
				Dispatch docs = app.getProperty("Documents").toDispatch();
				Dispatch doc = Dispatch.invoke(
						docs,
						"Open",
						Dispatch.Method,
						new Object[] { docfile, new Variant(false),
								new Variant(true) }, new int[1]).toDispatch();
				Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
						htmlfile, new Variant(WORD_HTML) }, new int[1]);
				Variant f = new Variant(false);
				Dispatch.call(doc, "Close", f);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				app.invoke("Quit", new Variant[] {});
				ComThread.Release();
			}
		}

		/**
		 * EXCEL转HTML
		 * 
		 * @param xlsfile
		 *            EXCEL文件全路径
		 * @param htmlfile
		 *            转换后HTML存放路径
		 */
		public static void excelToHtml(String xlsfile, String htmlfile) {
			// 初始化
			ComThread.InitSTA();
			ActiveXComponent app = new ActiveXComponent("Excel.Application"); // 启动Excel
			try {
				app.setProperty("Visible", new Variant(false));
				Dispatch excels = app.getProperty("Workbooks").toDispatch();
				Dispatch excel = Dispatch.invoke(
						excels,
						"Open",
						Dispatch.Method,
						new Object[] { xlsfile, new Variant(false),
								new Variant(true) }, new int[1]).toDispatch();
				Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[] {
						htmlfile, new Variant(EXCEL_HTML) }, new int[1]);
				Dispatch.call(excel, "Close", new Variant(false));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				app.invoke("Quit", new Variant[] {});
				ComThread.Release();
			}
		}
		
		/**
		 * EXCEL转XML
		 * 
		 * @param xlsfile
		 *            EXCEL文件全路径
		 * @param xmlfile
		 *            转换后XML存放路径
		 */
		public static void excelToXml(String xlsfile, String xmlfile) {
			// 初始化
			ComThread.InitSTA();
			ActiveXComponent app = new ActiveXComponent("Excel.Application"); // 启动Excel
			try {
				app.setProperty("Visible", new Variant(false));
				Dispatch excels = app.getProperty("Workbooks").toDispatch();
				Dispatch excel = Dispatch.invoke(
						excels,
						"Open",
						Dispatch.Method,
						new Object[] { xlsfile, new Variant(false),
								new Variant(true) }, new int[1]).toDispatch();
				Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[] {
						xmlfile, new Variant(EXCEL_XML) }, new int[1]);
				Variant f = new Variant(false);
				Dispatch.call(excel, "Close", f);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				app.invoke("Quit", new Variant[] {});
				ComThread.Release();
			}
		}
		
		public static void xlsToXlsx(String xlsfile, String xlsxfile) {
			// 初始化
			ComThread.InitSTA();
			ActiveXComponent app = new ActiveXComponent("Excel.Application"); // 启动Excel
			try {
				app.setProperty("Visible", new Variant(false));
				Dispatch excels = app.getProperty("Workbooks").toDispatch();
				Dispatch excel = Dispatch.invoke(
						excels,
						"Open",
						Dispatch.Method,
						new Object[] { xlsfile, new Variant(false),
								new Variant(true) }, new int[1]).toDispatch();
				Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[] {
						xlsxfile, new Variant(EXCEL_2003) }, new int[1]);
				Variant f = new Variant(false);
				Dispatch.call(excel, "Close", f);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				app.invoke("Quit", new Variant[] {});
				ComThread.Release();
			}
		}
		
	public static void excelToPdf(String xls, String pdf) {
		ActiveXComponent app = new ActiveXComponent("Excel.Application");
		try {
			app.setProperty("Visible", false);
			Dispatch workbooks = app.getProperty("Workbooks").toDispatch();
			System.out.println("opening document:" + xls);
			Dispatch workbook = Dispatch.invoke(workbooks, "Open", Dispatch.Method,
					new Object[] { xls, new Variant(false), new Variant(false) }, new int[3]).toDispatch();

			Dispatch.invoke(workbook, "SaveAs", Dispatch.Method,
					new Object[] { pdf, new Variant(57), new Variant(false), new Variant(57), new Variant(57),
							new Variant(false), new Variant(true), new Variant(57), new Variant(true),
							new Variant(true), new Variant(true) },
					new int[1]);
			Variant f = new Variant(false);
			Dispatch.call(workbook, "Close", f);
		} catch (Exception e) {
			System.out.println("========Error:Operation fail:" + e.getMessage());
		} finally {
			if (app != null) {
				app.invoke("Quit", new Variant[] {});
			}
			ComThread.Release();
		}
	}

		
		public static void main(String[] args) {
//			excelToHtml("E:\\test.xls","E:\\" + new Random().nextInt(1000) + ".html");
//			xlsToXlsx("D:\\BIOS\\工作明细-主系统.xls","D:\\BIOS\\工作明细-主系统.xlsx");
//			excelToPdf("D:\\BIOS\\工作明细-主系统.xlsx","D:\\BIOS\\工作明细-主系统1.pdf");
//			excelToPdf("D:\\BIOS\\工作明细-主系统.xlsx","D:\\BIOS\\工作明细-主系统1.pdf");
//			wordToPdf("D:\\BIOS\\web端系统集成说明.docx","D:\\BIOS\\web端系统集成说明.pdf");
			excelToHtml("D:\\BIOS\\工作明细-主系统.xls","D:\\BIOS\\工作明细-主系统.html");
		}
}
