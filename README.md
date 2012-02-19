Chaname - ChatNameMentioner for Craftbukkit using the Bukkit-API
================================================================

This plugin provide a simple syntax for colored private messages.

How does it work?
-----------------

### Sending a message

The player just need to type:

    @receiverName: messages

After that the receiver will get a message like this:

    <SenderName> message

The `<SenderName>` is highlighted with a extra color. The `message` also. Now one except the receiver can see
the message.



Configuration
-------------

Chaname is using the Configuration API of Bukkit and provide some options to customize your plugin.

### General

#### `copyTo` (Default: false)

If this is set to true, the sender will get his message as copy, so it's aviable in his chat history.

    copyTo: true

### Colors

You can define the colors that should be used to highlight the message and the sender.
_NOTE:_ You can only use colors defined
by the Bukkit team. See for more information.

#### `senderColor` (Default: DARK_AQUA)

Define the color to highlight the sender.

#### `messageColor` (Default: GOLD)

Define the color to highlight the message.

Permissions
-----------

You can define how is able to use the Chaname through the Permissions API.

### General

#### `chaname.send` (Default: true)

Define who could send messages with Chaname.

### `chaname.receive` (Default: true)

Define who could receive messages with Chaname.

Known Bugs
----------

No known bugs actually.

TODO:
-----

- Adding features:
	- multiple user mentioning
	- custom format? e.g. "[%sender] tell you: %message"
	- Configuration
	    - of cause colors
	    - send a copy to the sender --> copyTo
	- Permissions
	    - send messages
	    - receive messages