Chaname - ChatNameMentioner for Craftbukkit using the Bukkit-API
================================================================

This plugin provide a simple syntax for colored private messages.

How does it work?
-----------------

### Sending a message

The player just need to type:

    @receiverName: message

or

    @receiverName message

After that the receiver will get a message like this:

    <SenderName> message

The `<SenderName>` is highlighted with a extra color. The `message` also. No one except the receiver can see
the message. If a player want's to mention more than one user he can type:

	@receiverName1, receiverName2: message



Configuration
-------------

Chaname is using the Configuration API of Bukkit and provide some options to customize your plugin.

### General

#### `copyTo` (Default: false)

If this is set to true, the sender will get his message as copy, so it's available in his chat history.

### Colors

You can define the colors that should be used to highlight the message and the sender.

__NOTE:__ You can only use colors defined by the Bukkit team. See [ChatColors](http://jd.bukkit.org/apidocs/org/bukkit/ChatColor.html) for more information.

#### `senderColor` (Default: DARK_AQUA)

Define the color to highlight the sender.

#### `messageColor` (Default: GOLD)

Define the color to highlight the message.

#### `forceColor` (Default: false)

Use this to force using colors defined in the config.yml. Otherwise if e.g. the
sender is a admin and his chat color is red, Chaname will keep it by default. Instead
of DARK_AQUA you get a red sender color.

Permissions
-----------

You can define how is able to use the Chaname through the Permissions API.

### General

#### `chaname.mentionMulti` (Default: true)

Define if a user could mention more than one user.

#### `chaname.send` (Default: true)

Define who could send messages with Chaname.

#### `chaname.receive` (Default: true)

Define who could receive messages with Chaname.

Known Bugs
----------

No known bugs actually.

TODO:
-----

- Adding features:
	- custom format? e.g. "[%sender] tell you: %message"