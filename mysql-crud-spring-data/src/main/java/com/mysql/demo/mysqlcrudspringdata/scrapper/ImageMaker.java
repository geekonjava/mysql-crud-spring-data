package com.mysql.demo.mysqlcrudspringdata.scrapper;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageMaker {

	public static void main(String[] args) {
//		File sourceImageFile = new File("E:/Sawan/Testing/digital_image_processing.jpg");
//		File destImageFile = new File("E:/Sawan/Testing/digital_image_processing_text_watermarked.jpg");
//		 
//		addTextWatermark("CodeJava", sourceImageFile, destImageFile);
		
		File sourceImageFile = new File("E:/Sawan/Testing/digital_image_processing.jpg");
		File watermarkImageFile = new File("E:/Sawan/Testing/CodeJavaLogo.png");
		File destImageFile = new File("E:/Sawan/Testing/digital_image_processing_image_watermarked.jpg");
		 
		addImageWatermark(watermarkImageFile, sourceImageFile, destImageFile);

	}
	
	/**
	 * Embeds a textual watermark over a source image to produce
	 * a watermarked one.
	 * @param text The text to be embedded as watermark.
	 * @param sourceImageFile The source image file.
	 * @param destImageFile The output image file.
	 */
	static void addTextWatermark(String text, File sourceImageFile, File destImageFile) {
	    try {
	        BufferedImage sourceImage = ImageIO.read(sourceImageFile);
	        Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
	 
	        // initializes necessary graphic properties
	        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f);
	        g2d.setComposite(alphaChannel);
	        g2d.setColor(Color.BLUE);
	        g2d.setFont(new Font("Arial", Font.BOLD, 64));
	        FontMetrics fontMetrics = g2d.getFontMetrics();
	        Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);
	 
	        // calculates the coordinate where the String is painted
	        int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
	        int centerY = sourceImage.getHeight() / 2;
	 
	        // paints the textual watermark
	        g2d.drawString(text, centerX, centerY);
	 
	        ImageIO.write(sourceImage, "png", destImageFile);
	        g2d.dispose();
	 
	        System.out.println("The tex watermark is added to the image.");
	 
	    } catch (IOException ex) {
	        System.err.println(ex);
	    }
	}
	
	
	/**
	 * Embeds an image watermark over a source image to produce
	 * a watermarked one.
	 * @param watermarkImageFile The image file used as the watermark.
	 * @param sourceImageFile The source image file.
	 * @param destImageFile The output image file.
	 */
	static void addImageWatermark(File watermarkImageFile, File sourceImageFile, File destImageFile) {
	    try {
	        BufferedImage sourceImage = ImageIO.read(sourceImageFile);
	        BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);
	 
	        // initializes necessary graphic properties
	        Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
	        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
	        g2d.setComposite(alphaChannel);
	 
	        // calculates the coordinate where the image is painted
	        System.out.println(String.format("sourceImage.getWidth()::%d - watermarkImage.getWidth()::%d = %d", sourceImage.getWidth() , watermarkImage.getWidth(), sourceImage.getWidth() - watermarkImage.getWidth()));
	        System.out.println(String.format("sourceImage.getHeight()::%d - watermarkImage.getHeight()::%d = %d", sourceImage.getHeight() ,watermarkImage.getHeight(), sourceImage.getHeight() - watermarkImage.getHeight()));
	        int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
	        int topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;
	        
	        System.out.println("topLeftX:::"+topLeftX);
	        System.out.println("topLeftY:::"+topLeftY);
	 
	        // paints the image watermark
	        g2d.drawImage(watermarkImage, 127,0, null);
	 
	        ImageIO.write(sourceImage, "png", destImageFile);
	        g2d.dispose();
	        
	        /**
	         * 
	         	left top       0,0
				left bottom    0,230
				middle		   115,127
				middle left	   0,127
				middle right   230,127
				middle top     127,0
				middle bottom  115,254
				right top	   230,0
				right bottom   230,254
	         */
	 
	        System.out.println("The image watermark is added to the image.");
	 
	    } catch (IOException ex) {
	        System.err.println(ex);
	    }
	}

	
	

}
