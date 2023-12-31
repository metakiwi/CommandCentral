# CommandCentral
![Logo](https://raw.githubusercontent.com/metakiwi/CommandCentral/main/images/logo.png)

Download latest release file: https://github.com/metakiwi/CommandCentral/releases/latest/download/CommandCentral.jar

## General
Plugin for *Bukkit and Waterfall*. Hooks into Minecraft command suggestions and filter them by *permissions*. Compiled against Java 8 and Bukkit 1.13 for maximum compability.

![Demo](https://raw.githubusercontent.com/metakiwi/CommandCentral/main/images/demo.png)

## Installation
Drop JAR file in your `/plugins/` folder and restart server(s). The JAR file works for *both* platforms (Bukkit/Waterfall). There is no config file since everything is configured by permissions.

## Usage
By default CommandCentral automatically
* hides commands the player don't have the permission set (e.g. `/server`, `/send`, `/fly`)
* hides commands without a plugin permission node attached (e.g. `/ver`, `/pl`, `//pos1`, ...)
* hides commands containing a colon (`:`) (e.g `/bukkit:?`, `/essentials:tp`, ...)

You can adjust the behaviour by setting group/user permissions in your favorite permissions manager (like LuckPerms):
* `commandcentral.bypass` - don't filter any commands
* `commandcentral.showColonCommands` - don't filter commands containing a colon
* `commandcentral.show.<command>` - don't filter `<command>`
* `commandcentral.hide.<command>` - filter `<command>`
* `commandcentral.showplugin.<PluginName>` - don't filter commands from `<PluginName>`. Case sensitive! Get the plugin name from logs or `/plugins`.
* `commandcentral.hideplugin.<PluginName>` - filter commands from `<PluginName>`. Case sensitive! Get the plugin name from logs or `/plugins`.

## Support
Discord: https://discord.gg/uVuvWgfjHk

## Bugs, suggestions, feature requests
Please just file a [GitHub issue](https://github.com/metakiwi/CommandCentral/issues).

## Building
Dependencies and building is all set up in maven. So building the jar file is simply done by:
* Install Maven and Java `apt install maven openjdk-8-jdk-headless` (I use OpenJDK 8 for my releases but higher versions work as well)
* Checkout repository `git clone https://github.com/metakiwi/CommandCentral.git`
* Build with maven `mvn clean package`
The resulting jar file will be located in `target/CommandCentral.jar`
