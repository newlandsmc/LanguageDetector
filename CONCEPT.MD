### Language Detector
<html>
    <hr>
</html>

## Concept

A plugin to check every chat message and get what language the chat message is in using [Detect Language](https://detectlanguage.com/).
If the API returns that it is not english, and it has a high confidence score,
The plugin would warn the user to only use english and mute them if they continue.

##Working

1. Player sends chat message
2. Plugin gets message, checks against configured `ignore-regex`
3. If message matches regex, stop
4. If message does NOT support regex, make API call
5. If API returns non-english with high confidence (>`15`), send warning message to user and add 1 strike to player
6. Strikes expire after `10 minutes`.
7. Repeat 1-5 for each msg, if player gets 3 strikes, run `tempmute <player> 30m Auto-detected non-English in public chat`

## Notes

- Should only check public messages
- Should run async and NOT perform check before message is sent in chat (this could cause chat delay and lag)
- Should have regex support for configurable list of messages to ignore