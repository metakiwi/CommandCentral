# CommandCentral
![Logo](https://raw.githubusercontent.com/metakiwi/CommandCentral/main/images/logo.png)

Download the latest release file: https://github.com/metakiwi/CommandCentral/releases/latest/download/CommandCentral.jar

## General
CommandCentral is a plugin for *Bukkit and Waterfall* that hooks into Minecraft command suggestions and filters or blocks them based on *permissions*. It is compiled against Java 8 and Bukkit 1.13 to ensure maximum compatibility.

This plugin addresses the issue where plugins like WorldEdit, EssentialsX, and many others register numerous commands that most users don't need and can't use, cluttering the command suggestion list and rendering it less useful. CommandCentral cleans up your command suggestion list, making it nice, shiny, and helpful again. Additionally, its built-in firewall (command blocker) adds a second layer of security to your servers.

![Demo](https://raw.githubusercontent.com/metakiwi/CommandCentral/main/images/demo.png)

## Installation
Drop the JAR file into your `/plugins/` folder and restart your server(s). The JAR file is compatible with *both* Bukkit and Waterfall platforms. There is no configuration file, as everything is managed through permissions.

## Usage
Adjust the behavior by setting group/user permissions in your preferred permissions manager (like LuckPerms):
* `commandcentral.filter` - Activates CommandCentral filtering and blocking for a user/group.
* `commandcentral.command.<command>` - Allows `<command>` for a user/group.

## Examples
* `/lp group default permission set commandcentral.command.warp` - Allow /warp
* `/lp group default permission set commandcentral.command.spawn` - Allow /spawn
* `/lp group default permission set commandcentral.command.home` - Allow /home
* `/lp group default permission set commandcentral.command.sethome` - Allow /sethome
* `/lp group default permission set commandcentral.filter` - Activate CommandCentral for group `default`

This setup allows users to only use and see `/warp`, `/spawn`, `/home`, and `/sethome`. Everything else is blocked and also filtered out of the command suggestion list.

To deactivate filtering for admin groups that inherit from the default, use:
* `/lp group admin permission set commandcentral.filter false`

OPs are excluded from filtering and blocking; they will always see everything.

## Support
For support, join our Discord: https://discord.gg/uVuvWgfjHk

## Bugs, Suggestions, Feature Requests
To report bugs, suggest improvements, or request new features, please file a [GitHub issue](https://github.com/metakiwi/CommandCentral/issues).

## Building
The project uses Maven for dependency management and building. To build the jar file:
* Install Maven and Java with `apt install maven openjdk-8-jdk-headless` (Although I use OpenJDK 8 for my releases, higher versions also work.)
* Clone the repository `git clone https://github.com/metakiwi/CommandCentral.git`
* Build with Maven `mvn clean package`

The resulting jar file will be located in `target/CommandCentral.jar`.