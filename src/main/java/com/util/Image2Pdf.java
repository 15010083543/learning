package com.util;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.*;

public class Image2Pdf {
    public static void main(String[] args) {
        String imagePath = "src/main/resources/image/2.png"; // 图像路径
        String pdfPath = "src/main/resources/image/22.pdf"; // 输出 PDF 路径

        try {
            // 创建一个新的 PDF 文档
            PDDocument document = new PDDocument();

            // 加载图像

            byte[] imageBytes = imageToByteArray(imagePath);

            // 加载图片
            PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, imageBytes, "2.png");

            // 创建一个新的页面
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // 计算图片的缩放比例
            float scaleX = page.getMediaBox().getWidth() / pdImage.getWidth();
            float scaleY = page.getMediaBox().getHeight() / pdImage.getHeight();
            float scale = Math.min(scaleX, scaleY); // 保持图片比例

            // 计算图片的绘制坐标（居中显示）
            /*float x = (float) (page.getMediaBox().getWidth() - pdImage.getWidth() * scale) / 2;
            float y = (float) (page.getMediaBox().getHeight() - pdImage.getHeight() * scale) / 2;*/

            // 设置图像的 X 和 Y 位置
            float xPosition = 10; // x坐标
            float yPosition = page.getMediaBox().getHeight() - pdImage.getHeight() - 10; // y坐标，确保Y坐标在页面内

            // 将图像添加到页面
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                //contentStream.drawImage(pdImage, 0, 0, scale, scale);
                contentStream.drawImage(pdImage, xPosition, yPosition, pdImage.getWidth() * scale, pdImage.getHeight() * scale);
            }

            // 将PDF文档写入字节输出流
            /*try (ByteArrayOutputStream pdfBaos = new ByteArrayOutputStream()) {
                document.save(pdfBaos);
                System.out.println(pdfBaos);
                //return pdfBaos; // 返回PDF的字节流
            }*/

            // 保存并关闭 PDF 文档
            document.save(pdfPath);
            document.close();

            System.out.println("PDF created successfully: " + pdfPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] imageToByteArray(String imagePath) throws Exception {
        // 创建一个 FileInputStream 对象来读取图片文件
        try (InputStream inputStream = new FileInputStream(imagePath)) {
            // 创建一个 ByteArrayOutputStream 来存储图片的字节
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            // 从 inputStream 读取数据到 buffer，并写入 outputStream
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            // 将输出流转换为字节数组
            return outputStream.toByteArray();
        }
    }
}
