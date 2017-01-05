package com.ueh.common.util;

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


    /**
     * Excel文档转换
     * 
     * @param inputFile
     * @param pdfFile
     * @author SHANHY
     */
    private static boolean excel2PDF(String inputFile, String pdfFile) {
        ComThread.InitSTA();

        long start = System.currentTimeMillis();
        ActiveXComponent app = null;
        Dispatch excel = null;
        try {
            app = new ActiveXComponent("Excel.Application");// 创建一个PPT对象
            app.setProperty("Visible", new Variant(false)); // 不可见打开
            // app.setProperty("AutomationSecurity", new Variant(3)); // 禁用宏
            Dispatch excels = app.getProperty("Workbooks").toDispatch();// 获取文挡属性

            System.out.println("打开文档 >>> " + inputFile);
            // 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
            excel = Dispatch.call(excels, "Open", inputFile, false, true).toDispatch();
            // 调用Document对象方法，将文档保存为pdf格式
            System.out.println("转换文档 [" + inputFile + "] >>> [" + pdfFile + "]");
            // Excel 不能调用SaveAs方法
         //   Dispatch.call(excel, "ExportAsFixedFormat", xlFormatPDF, pdfFile);
            Dispatch.call(excel, "SaveAs", pdfFile);  
            long end = System.currentTimeMillis();

            System.out.println("用时：" + (end - start) + "ms.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("========Error:文档转换失败：" + e.getMessage());
        } finally {
            Dispatch.call(excel, "Close", false);
            System.out.println("关闭文档");
            if (app != null)
                app.invoke("Quit", new Variant[] {});
        }
        ComThread.Release();
        ComThread.quitMainSTA();
        return false;
    }


	public static void word2PDF(String inputFile,String pdfFile){ 
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
		
		public static void main(String[] args) {
//			excelToHtml("E:\\test.xls","E:\\" + new Random().nextInt(1000) + ".html");
			xlsToXlsx("D:\\BIOS\\工作明细-主系统.xls","D:\\BIOS\\工作明细-主系统.xlsx");
//			word2PDF("D:\\BIOS\\web端系统集成说明.docx","D:\\BIOS\\web端系统集成说明.pdf");
//			excel2PDF("D:\\BIOS\\工作明细-主系统.xls","D:\\BIOS\\工作明细-主系统.xlsx");
		}
}
