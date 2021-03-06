/**
 * Copyright 2012 Andy Turner, The University of Leeds, UK
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package uk.ac.leeds.ccg.andyt.generic.visualisation.charts;

import java.io.File;
import java.math.RoundingMode;
import javax.swing.JFrame;
import uk.ac.leeds.ccg.andyt.generic.visualisation.Generic_Visualisation;

/**
 * An implementation of
 * <code>Generic_JApplet_AgeGenderLineChart<\code>
 *
 * If you run this class it will attempt to generate an Age by Gender
 * Population Line Chart Visualization of some default data and display it on
 * screen.
 */
public class Generic_JApplet_AgeGenderLineChart extends Generic_AbstractAgeGenderPlotApplet {

    public Generic_JApplet_AgeGenderLineChart() {
    }

    public Generic_JApplet_AgeGenderLineChart(
            File file,
            String format,
            String title,
            int dataWidth,
            int dataHeight,
            String xAxisLabel,
            String yAxisLabel,
            boolean drawOriginLinesOnPlot,
            int ageInterval,
            int startAgeOfEndYearInterval,
            int decimalPlacePrecisionForCalculations,
            int decimalPlacePrecisionForDisplay,
            RoundingMode roundingMode) {
        _Generic_Plot = new Generic_AgeGenderLineChart(
                null,
                file,
                format,
                title,
                dataWidth,
                dataHeight,
                xAxisLabel,
                yAxisLabel,
                drawOriginLinesOnPlot,
                ageInterval,
                startAgeOfEndYearInterval,
                decimalPlacePrecisionForCalculations,
                decimalPlacePrecisionForDisplay,
                roundingMode);
    }

    public static void main(String[] args) {
        Generic_Visualisation.getHeadlessEnvironment();
        /*
         * Initialise title and File to write image to
         */
        String title;
        File file;
        String format = "PNG";
        if (args.length != 2) {
            System.out.println(
                    "Expected 2 args:"
                    + " args[0] title;"
                    + " args[1] File."
                    + " Recieved " + args.length + " args.");
            // Use defaults
            title = "Age Gender Population Line Chart";
            System.out.println("Use default title: " + title);
            file = new File(
                    new File(System.getProperty("user.dir")),
                    title.replace(" ", "_") + "." + format);
            System.out.println("Use default File: " + file.toString());
        } else {
            title = args[0];
            file = new File(args[1]);
        }
        /*
         * Initialise a container of showing on-screen
         */
        //Panel p = new Panel();
        JFrame jFrame = getJFrame(title);
        //int boundaryThickness = 20;
        int dataWidth = 1000;//250;
        int dataHeight = 500;
        String xAxisLabel = "Population";
        String yAxisLabel = "Age";
        boolean drawOriginLinesOnPlot = true;
        int ageInterval = 1;
        int startAgeOfEndYearInterval = 90;//95;
        int decimalPlacePrecisionForCalculations = 10;
        int decimalPlacePrecisionForDisplay = 3;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        Generic_JApplet_AgeGenderLineChart plot = new Generic_JApplet_AgeGenderLineChart(
                file,
                format,
                title,
                dataWidth,
                dataHeight,
                xAxisLabel,
                yAxisLabel,
                drawOriginLinesOnPlot,
                ageInterval,
                startAgeOfEndYearInterval,
                decimalPlacePrecisionForCalculations,
                decimalPlacePrecisionForDisplay,
                roundingMode);
        plot.setData(Generic_AgeGenderLineChart.getDefaultData(
                ageInterval,
                startAgeOfEndYearInterval,
                decimalPlacePrecisionForCalculations,
                roundingMode));
        plot.run(jFrame);
    }

    @Override
    public void setOriginCol() {
        ((Generic_AgeGenderLineChart) _Generic_Plot).setOriginCol();
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
