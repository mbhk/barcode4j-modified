/*
 * Copyright 2002-2004 Jeremias Maerki.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.krysalis.barcode4j.impl;

import org.krysalis.barcode4j.BarcodeDimension;
import org.krysalis.barcode4j.BarcodeGenerator;
import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.output.CanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 * Base class for most barcode implementations.
 * 
 * @author Jeremias Maerki
 * @version $Id$
 */
public abstract class AbstractBarcodeBean 
            implements BarcodeGenerator {

    /** Net height of bars in mm */
    protected double height          = 15.0; //mm
    /** Width of narrow module in mm */
    protected double moduleWidth;
    /** Position of human-readable text */
    protected HumanReadablePlacement msgPos = HumanReadablePlacement.HRP_BOTTOM;
    /** Font size in mm */
    protected double fontSize        = UnitConv.pt2mm(8); //8pt
    /** Font name */
    protected String fontName        = "Helvetica"; //"OCR-B,Helvetica,Arial";
    /** True if quiet zone should be rendered */
    protected boolean doQuietZone    = true;
    /** Width of the quiet zone left and right of the barcode in mm */
    protected double quietZone;

    
    /**
     * Returns the height of the human-readable part.
     * @return the height of the human-readable part (in mm)
     */
    public double getHumanReadableHeight() {
        double textHeight = this.fontSize;
        return 1.0 * textHeight;
    }

    /**
     * Returns the height of the bars.
     * @return the height of the bars (in mm)
     */
    public double getBarHeight() {
        return this.height;
    }

    /**
     * Returns the full height of the barcode.
     * @return the full height (in mm)
     */
    public double getHeight() {
        return getBarHeight() + getHumanReadableHeight();
    }

    /**
     * Sets the height of the bars.
     * @param height the height of the bars (in mm)
     */
    public void setBarHeight(double height) {
        this.height = height;
    }

    /**
     * Sets the full height of the barcode.
     * @param height the full height (in mm)
     */
    public void setHeight(double height) {
        this.height = height - getHumanReadableHeight();
    }

    /**
     * Returns the width of the narrow module.
     * @return the width of the narrow module (in mm)
     */
    public double getModuleWidth() {
        return this.moduleWidth;
    }

    /**
     * Sets the width of the narrow module.
     * @param width the width of the narrow module (in mm)
     */
    public void setModuleWidth(double width) {
        this.moduleWidth = width;
    }
    
    /**
     * Returns the effective width of a bar with a given logical width.
     * @param width the logical width (1=narrow, 2=wide)
     * @return the effective width of a bar (in mm)
     */
    public abstract double getBarWidth(int width);

    /**
     * Indicates whether a quiet zone is included.
     * @return true if a quiet zone is included
     */
    public boolean hasQuietZone() {
        return this.doQuietZone;
    }

    /**
     * Controls whether a quiet zone should be included or not.
     * @param value true if a quiet zone should be included
     */
    public void doQuietZone(boolean value) {
        this.doQuietZone = value;
    }

    /**
     * Returns the width of the quiet zone.
     * @return the width of the quiet zone (in mm)
     */
    public double getQuietZone() {
        return this.quietZone;
    }

    /**
     * Sets the width of the quiet zone.
     * @param width the width of the quiet zone (in mm)
     */
    public void setQuietZone(double width) {
        this.quietZone = width;
    }
    
    /**
     * Returns the placement of the human-readable part.
     * @return the placement of the human-readable part
     */
    public HumanReadablePlacement getMsgPosition() {
        return this.msgPos;
    }

    /**
     * Sets the placement of the human-readable part.
     * @param placement the placement of the human-readable part
     */
    public void setMsgPosition(HumanReadablePlacement placement) {
        this.msgPos = placement;
    }
    
    /**
     * Returns the font size of the human-readable part.
     * @return the font size
     */
    public double getFontSize() {
        return this.fontSize;
    }
    
    /**
     * Sets the font size of the human-readable part.
     * @param size the font size
     */
    public void setFontSize(double size) {
        this.fontSize = size;
    }

    /**
     * Returns the font name of the human-readable part.
     * @return the font name
     */
    public String getFontName() {
        return this.fontName;
    }
    
    /**
     * Sets the font name of the human-readable part.
     * @param name the font name
     */
    public void setFontName(String name) {
        this.fontName = name;
    }
    
    /** @see org.krysalis.barcode4j.BarcodeGenerator */
    public abstract void generateBarcode(CanvasProvider canvas, String msg);
    
    /** @see org.krysalis.barcode4j.BarcodeGenerator */
    public BarcodeDimension calcDimensions(String msg) {
        throw new UnsupportedOperationException("NYI");
    }
}
