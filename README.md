# ArrowOwnershipFix

A Minecraft plugin that fixes arrow ownership issues introduced in Minecraft 1.21.6, specifically designed for technical builds and wireless redstone systems.

## What it does

This plugin undoes a change made in Minecraft 1.21.6 that removes an arrow's owner when the player who shot it logs out. This is particularly useful for technical builds that involve wireless redstone systems using arrows.

## Why it's needed

In Minecraft 1.21.6, Mojang changed the behavior of arrows so that when a player logs out, any arrows they shot lose their ownership information after some time. This breaks many technical builds that rely on arrow-based wireless redstone systems such as [Squibble's Mirror Pylon](https://www.youtube.com/watch?v=MxEMNUu06bk&list=PLZPtY-eJMgv2Iyul9K09GleTclelH-r61&ab_channel=Squibble), where arrows need to maintain their ownership to track the player's look direction.

## Features

- **Automatic Restoration**: Arrow ownership is automatically restored through multiple efficient mechanisms
- **Efficient Processing**: Uses entity load events to process arrows as they enter the world, minimizing performance impact
- **Comprehensive Coverage**: Handles arrows across chunk loading, server restarts, and player reconnections
- **Lightweight**: Minimal performance impact with optimized event handling
- **Compatible**: Works with Minecraft 1.21.6+ servers

## Installation

1. **Download** the latest `ArrowOwnershipFix.jar` from the releases
2. **Place** the JAR file in your server's `plugins/` folder
3. **Restart** your server
4. **Done!** The plugin will automatically start working

## Requirements

- **Minecraft Version**: 1.21.6 or higher
- **Server Type**: Spigot, Paper, or any Spigot-based server
- **Java Version**: 17 or higher

## How it works

The plugin works by:

1. **Tracking Arrow Launches**: When a player shoots an arrow, the plugin stores the player's UUID in the arrow's persistent data
2. **Maintaining Ownership**: The arrow retains this ownership information even when the player logs out
3. **Restoring Ownership**: The plugin automatically restores arrow ownership through multiple mechanisms:
   - **Entity Loading**: When arrows load into the world (chunk loading, server restart), their ownership is immediately restored
   - **Player Rejoin**: When a player rejoins, all existing arrows are scanned and ownership is restored for arrows belonging to that player
   - **Server Startup**: On plugin enable, all loaded arrows have their ownership restored

## Configuration

This plugin requires no configuration - it works out of the box with default settings.

## Building from source

If you want to build the plugin from source:

```bash
# Clone the repository
git clone https://github.com/yourusername/ArrowOwnershipFix.git
cd ArrowOwnershipFix

# Build with Maven
mvn clean package

# The compiled JAR will be in the target/ directory
```

## Technical Details

- **Main Class**: `me.okay.ArrowOwnershipFix`
- **API Version**: 1.21.6
- **Dependencies**: Spigot API (provided scope)

## Contributing

Contributions are welcome! Please feel free to submit issues or pull requests.

## License

This project is open source. Please check the license file for more details.

## Support

If you encounter any issues or have questions:

1. Check the [Issues](https://github.com/yourusername/ArrowOwnershipFix/issues) page
2. Create a new issue with detailed information about your problem
3. Include your server version, plugin version, and any error messages

## Credits

- **Author**: okay1204
- **Version**: 1.0
- **For**: Technical Minecraft community

---

**Note**: This plugin is specifically designed for technical Minecraft builds and may not be necessary for regular gameplay servers. 