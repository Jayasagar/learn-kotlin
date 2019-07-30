package com.jay.basics

class StreamTest {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            // Test Data
            val event1 = Event("switchedOn", true)
            val event2 = Event("switchedOff", true)

            val bulbEvents = listOf(event1, event2)
            val motionDetectorEvents = listOf(Event("motionCaptured", true))
            val eyeVirusEvents = listOf(Event("virusFound", true))
            val waterLevelsEvents = listOf(Event("dryField", true))

            val thingBulb = Thing("Bulb", true, Type.HOME, 120, bulbEvents)
            val thingMotionDetector = Thing("MotionDetector", true, Type.HOME, 60, motionDetectorEvents)
            val thingEyeVirusDetector = Thing("EyeVirusDetector", true, Type.HEALTH, 200, eyeVirusEvents)
            val thingAgriFieldSensor = Thing("AgriFieldSensor", true, Type.HEALTH, 300, waterLevelsEvents)

            val consumers: List<Consumer> = listOf(
                Consumer("Malli", "Hyd", 27, listOf(thingBulb, thingMotionDetector)),
                Consumer("Sri", "Hyd", 32, listOf(thingBulb, thingEyeVirusDetector)),
                Consumer("Satti", "Hyd", 25, listOf(thingAgriFieldSensor, thingMotionDetector)),
                Consumer("Bob", "Berlin", 35, listOf(
                    thingBulb, thingAgriFieldSensor, thingEyeVirusDetector, thingMotionDetector
                ))
            )


            // Example 1: Get consumers by age > 30
            println(consumers.filter { it.age > 30 }.map { it.name })

            // Example 2: Get consumers by age > 30, map by their name and devices
//            println(consumers.filter { it.age > 30 }.map { it.name to it.things }.toMap())
            println(consumers.filter { it.age > 30 }.associateBy({ it.name}, {it.things }))

            // Example 3: Get consumer ‘Bob’ devices sort by name
            println(consumers.filter { it.name == "Bob" }.flatMap { it.things }.sortedBy { it.name })

            // Example 4: Get all the unique cities of consumers
            println(consumers.map { it.city }.toSet())

            // Example 5: Are there any consumer living in Berlin?
            println(consumers.any { it.city == "Berlin" })

        }

    }
}