import com.sap.gateway.ip.core.customdev.util.Message
 
def Message processData(Message message) {
 
    // Read raw bytes
    byte[] body = message.getBody(byte[].class)
 
    // Convert from UTF-16LE (AL11 default)
    String text = new String(body, "UTF-16LE")
 
    // Set clean text back
    message.setBody(text)
 
    return message
}