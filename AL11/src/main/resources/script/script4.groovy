import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    byte[] bytes = message.getBody(byte[].class)

    // Convert from UTF-16LE to proper String
    String text = new String(bytes, "UTF-16LE")

    // Remove any accidental spaces around pipes
    text = text.replaceAll("\\s*\\|\\s*", "|")

    message.setBody(text)

    return message
}