## Pi4J Traffic Light Module Test

This Java application demonstrates how to control a 3-LED traffic light module (Red, Yellow, Green) using the Pi4J library on a Raspberry Pi.

**Purpose:**

The `App.java` class provides a simple example of controlling a traffic light module connected to a Raspberry Pi using Pi4J v2. It showcases how to initialize Pi4J, configure digital output pins for controlling the Red, Yellow, and Green LEDs of a traffic light module, and then run a basic traffic light sequence. This example serves as a starting point for anyone wanting to simulate traffic lights or control multi-LED indicators in their Raspberry Pi projects using Pi4J.

**Functionality:**

* **Initialization:** Sets up the Pi4J context (`Pi4J.newAutoContext()`), which is the foundation for interacting with Raspberry Pi hardware through Pi4J.
* **GPIO Configuration:** Configures three digital output pins:
    * GPIO 17 (Pin 11 in BCM numbering) for the **Green** LED.
    * GPIO 27 (Pin 13 in BCM numbering) for the **Yellow** LED.
    * GPIO 22 (Pin 15 in BCM numbering) for the **Red** LED.
    It uses Pi4J's `DigitalOutput.Builder` for a clear and organized configuration of each LED.
* **Traffic Light Sequence:** Implements a basic traffic light sequence by:
    * Turning **Red** LED ON for 5 seconds.
    * Turning **Yellow** LED ON for 5 seconds.
    * Turning **Green** LED ON for 5 seconds.
    * Each LED is turned OFF after its designated ON duration.
* **Sequential LED Control:** Demonstrates how to control multiple digital outputs in a timed sequence using `TimeUnit.SECONDS.sleep()`.
* **Shutdown:** Properly shuts down the Pi4J context (`pi4j.shutdown()`) at the end of the program to release resources.

**Hardware Requirements:**

* **Raspberry Pi:** Any Raspberry Pi model supported by Pi4J.
* **3-LED Traffic Light Module:**  A common module containing Red, Yellow, and Green LEDs.
* **Wiring:** Jumper wires to connect the Traffic Light module to the Raspberry Pi GPIO pins as follows:
    * **GREEN LED:** GPIO17 (Pin 11)
    * **YELLOW LED:** GPIO27 (Pin 13)
    * **RED LED:** GPIO22 (Pin 15)
    * **GND:** Ground (Pin 6 or any other GND pin)

**Software Requirements:**

* **Java Development Kit (JDK):** Required to compile and run the Java code.
* **Pi4J Library:** This project is built using Pi4J v2. You'll need to include Pi4J as a dependency in your project (e.g., using Maven or Gradle).
* **Operating System:** Raspberry Pi OS (or any OS supported by Pi4J).

**How to Use:**

1. **Clone this repository.**
2. **Ensure you have Pi4J v2 set up in your project.** If you are using Maven, include the Pi4J core dependency in your `pom.xml`.
3. **Compile the `App.java` class.**
4. **Connect the Traffic Light module to your Raspberry Pi as described above.**
5. **Run the compiled `App` class on your Raspberry Pi.**

**Important Notes:**

* **GPIO Pin Numbering:** The code uses BCM (Broadcom) GPIO pin numbering. Ensure your wiring matches this numbering scheme.
* **LED Module Type:** This code assumes a common cathode traffic light module or LEDs where setting the GPIO pin HIGH turns the LED ON. If you are using a common anode module or different LED configuration, you may need to adjust the logic (e.g., use `DigitalState.LOW` to turn LEDs on).
* **Current Limiting:** Traffic light modules often include built-in current limiting resistors. If using individual LEDs, ensure you use appropriate resistors in series with each LED to prevent damage.
* **Permissions:** Ensure that the user running the Java application has the necessary permissions to access the Raspberry Pi's GPIO pins.

**Keywords:** Raspberry Pi, Pi4J, Traffic Light, LED Module, Red, Yellow, Green, GPIO, Java, IoT, Hardware, Example, Tutorial, Digital Output, LED Control, Sequencing.