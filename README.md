=== DeprecatedNether's <50 ===
**DeprecatedNether's <50** ("Under 50") is a Bukkit plugin that aims to add several commands and features (generally the basic things, like commands you'd find in Essentials).

There are two rules:
* The entire listener or command executor class for each command MUST be under 50 lines.
  * "Asterisk imports" (`import org.bukkit.*` are prohibited)
  * Code shouldn't be all "shoved" on one line - it must still be properly formatted (preferably following the [Google Java Style](https://google-styleguide.googlecode.com/svn/trunk/javaguide.html#s4.4-column-limit))
  * The line counting begins on the package declaration line. That means the copyright notice on top of each source file is not included in the line count.
* The 50-line-or-less classes must not depend on any external libraries other than Bukkit
