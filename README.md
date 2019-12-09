# PlayerFishingHeads

## About
Download [here](https://github.com/valkyrienyanko/PlayerFishingHeads/releases).

Plugin gives player heads from a config list of heads or heads from people currently in game.

### Configuration Tutorial

```yml
heads:
  ingame: true # If the heads should be grabbed from in game or from the config.
  chance: 1.0 # Chance the heads should spawn. Values range from 0.0 - 1.0. (0% - 100%)
  heads: # The heads grabbed from this config. The player head names don't have to be from people who have previously joined your server.
  - valkyrienyanko
  - bobthebuilder
  - saladass69
```

<details><summary>Config Preview (Click to Expand)</summary>
<p>

#### heads.yml

```yml
heads:
  ingame: true
  chance: 1.0
  heads:
  - valkyrienyanko
  - bobthebuilder
  - saladass69
```
</p>
</details>

## Compiling
1. Clone the repository directly into your IDE.
2. Build Spigot with [Spigot's Build Tools](https://www.spigotmc.org/wiki/buildtools/) then add the JAR to the projects build path.
3. Fix any outdated code in the project depending on what version of Spigot you installed.
4. Compile the plugin by exporting it to a JAR file.
