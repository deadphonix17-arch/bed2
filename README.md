# Stackable Beds & Fast Wool (Fabric, Minecraft 1.21.11)

- Beds (all colors) stack to **16**.
- Sheared sheep regrow wool every **5 seconds** (adult sheep only).

Tweak values in `BedsAndWoolMod.java` (`BED_STACK_SIZE`, `WOOL_REGROW_INTERVAL_TICKS`).

## Build
Requires JDK 21 and Gradle 9.4.1.

    gradle wrapper --gradle-version 9.4.1   # once, to generate gradlew
    ./gradlew build

The jar is in `build/libs/`. Pushing to GitHub runs the workflow in `.github/workflows/build.yml`;
pushing a tag like `v1.0.0` also publishes a release.
