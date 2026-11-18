import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    byte[] body = message.getBody(byte[].class)
    String text = new String(body, "UTF-16LE")

    // Normalize line breaks
    text = text.replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n")

    // Ensure single blank line between records
    text = text.split("\n")
               .collect { it.trim() }
               .findAll { it.length() > 0 }
               .join("\n\n")

    message.setBody(text)
    return message
}