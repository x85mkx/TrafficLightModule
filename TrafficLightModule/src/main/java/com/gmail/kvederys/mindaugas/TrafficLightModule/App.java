package com.gmail.kvederys.mindaugas.TrafficLightModule;

import com.pi4j.Pi4J; // Import Pi4J library core functionality
import com.pi4j.context.Context; // Import Pi4J context for managing resources
import com.pi4j.io.gpio.digital.DigitalOutput; // Import interface for digital output
import com.pi4j.io.gpio.digital.DigitalState; // Import enum for digital output states (HIGH/LOW)
import java.util.concurrent.TimeUnit; // Import TimeUnit for time-related operations, specifically for delays

/**
 * <h2>Traffic Light Module Test Application</h2>
 * <p>
 * This application demonstrates how to control a 3-LED traffic light module (typically Red, Yellow, Green)
 * using the Pi4J library on a Raspberry Pi or similar single-board computer.
 * The program simulates a basic traffic light sequence by turning on each LED in sequence for a specified duration.
 * </p>
 * <p>
 * This program initializes the Pi4J context, configures digital output pins for each LED (Green, Yellow, Red),
 * and then runs a simple sequence to turn on each LED individually for 5 seconds.
 * </p>
 * <p>
 * <b>Hardware Setup (Traffic Light module):</b>
 * <ul>
 *     <li><b>GPIO17 [Pin 11]</b> >> GREEN LED light - Connect to the control pin of the GREEN LED on the traffic light module.</li>
 *     <li><b>GPIO27 [Pin 13]</b> >> YELLOW LED light - Connect to the control pin of the YELLOW LED on the traffic light module.</li>
 *     <li><b>GPIO22 [Pin 15]</b> >> RED LED light   - Connect to the control pin of the RED LED on the traffic light module.</li>
 *     <li><b>GND [Pin 6]</b>     >> GROUND         - Connect to a common ground on Raspberry Pi for the traffic light module.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Important Notes:</b>
 * <ul>
 *     <li>Ensure you have correctly wired the traffic light module to your Raspberry Pi
 *         according to the pinout described above.</li>
 *     <li>Traffic light modules often have LEDs with built-in current limiting resistors. If you are using individual LEDs instead of a module,
 *         ensure you include appropriate current limiting resistors in series with each LED to prevent damage.</li>
 *     <li>Using the proper GPIO pins and a reliable ground connection is crucial for the application to function correctly.</li>
 *     <li>This example assumes a common cathode configuration for the LEDs, where setting the GPIO pin HIGH turns the LED ON.
 *         If using a common anode configuration, you would need to reverse the logic (e.g., use `DigitalState.LOW` to turn LEDs ON).</li>
 * </ul>
 * </p>
 * <p>
 * <b>Software Dependencies:</b>
 * This application requires the Pi4J library. Ensure that Pi4J is properly installed and configured in your project.
 * Refer to the Pi4J official documentation for installation instructions and setup guidance.
 * </p>
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Pi4J platform context.
        // Pi4J.newAutoContext() automatically detects the platform and initializes Pi4J.
        final Context pi4j = Pi4J.newAutoContext();

        // Configure DigitalOutput for the GREEN LED using Pi4J DigitalOutput Builder.
        // This sets up GPIO pin 17 as a digital output to control the Green LED.
        DigitalOutput green = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
                .id("green")                      // Assign a unique ID for the Green LED output (optional, but good practice).
                .name("Green LED")                // Assign a descriptive name for the Green LED output.
                .address(17)                      // Set the GPIO pin address to 17 (BCM numbering) for the Green LED control.
                .shutdown(DigitalState.LOW)       // Set the Green LED pin state to LOW on program shutdown (turn off LED on exit).
                .initial(DigitalState.LOW)        // Set the initial state of the Green LED pin to LOW (LED starts off).
                .build());                        // Build the DigitalOutputConfig object and create the DigitalOutput instance.

        // Configure DigitalOutput for the YELLOW LED using Pi4J DigitalOutput Builder.
        // This sets up GPIO pin 27 as a digital output to control the Yellow LED.
        DigitalOutput yellow = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
                .id("yellow")                     // Assign a unique ID for the Yellow LED output.
                .name("Yellow LED")               // Assign a descriptive name for the Yellow LED output.
                .address(27)                      // Set the GPIO pin address to 27 (BCM numbering) for the Yellow LED control.
                .shutdown(DigitalState.LOW)       // Set the Yellow LED pin state to LOW on program shutdown.
                .initial(DigitalState.LOW)        // Set the initial state of the Yellow LED pin to LOW.
                .build());                        // Build the DigitalOutputConfig object and create the DigitalOutput instance.

        // Configure DigitalOutput for the RED LED using Pi4J DigitalOutput Builder.
        // This sets up GPIO pin 22 as a digital output to control the Red LED.
        DigitalOutput red = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
                .id("red")                        // Assign a unique ID for the Red LED output.
                .name("Red LED")                  // Assign a descriptive name for the Red LED output.
                .address(22)                      // Set the GPIO pin address to 22 (BCM numbering) for the Red LED control.
                .shutdown(DigitalState.LOW)       // Set the Red LED pin state to LOW on program shutdown.
                .initial(DigitalState.LOW)        // Set the initial state of the Red LED pin to LOW.
                .build());                        // Build the DigitalOutputConfig object and create the DigitalOutput instance.

        System.out.println("Turning on Red LED..."); // Print message to console indicating Red LED is being turned on.
        red.high();                                 // Set RED LED pin to HIGH, turning the Red LED ON.
        TimeUnit.SECONDS.sleep(5);                  // Pause for 5 seconds, keeping the Red LED ON for this duration.
        red.low();                                  // Set RED LED pin to LOW, turning the Red LED OFF.

        System.out.println("Turning on Yellow LED..."); // Print message to console indicating Yellow LED is being turned on.
        yellow.high();                              // Set YELLOW LED pin to HIGH, turning the Yellow LED ON.
        TimeUnit.SECONDS.sleep(5);                  // Pause for 5 seconds, keeping the Yellow LED ON for this duration.
        yellow.low();                               // Set YELLOW LED pin to LOW, turning the Yellow LED OFF.

        System.out.println("Turning on Green LED...");  // Print message to console indicating Green LED is being turned on.
        green.high();                               // Set GREEN LED pin to HIGH, turning the Green LED ON.
        TimeUnit.SECONDS.sleep(5);                  // Pause for 5 seconds, keeping the Green LED ON for this duration.
        green.low();                                // Set GREEN LED pin to LOW, turning the Green LED OFF.

        pi4j.shutdown();                            // Shutdown Pi4J context to release resources after program execution.
        System.out.println("Pi4J context shutdown."); // Print message to console indicating Pi4J context shutdown.
    }
}