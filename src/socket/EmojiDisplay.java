/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

/**
 *
 * @author upagy
 */
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class EmojiDisplay {

    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Emoji Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        // Create a panel to hold the emojis
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Fetch emojis and add them to the panel
        try {
            // URL for emoji API
            String urlString = "https://emojihub.yurace.pro/api/all";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Close connections
            in.close();
            connection.disconnect();

            // Parse JSON response
            JSONArray emojiArray = new JSONArray(content.toString());

            // Iterate through the emojis and add them to the panel
            for (int i = 0; i < emojiArray.length(); i++) {
                JSONObject emojiObject = emojiArray.getJSONObject(i);
                String emojiHtmlCode = emojiObject.getJSONArray("htmlCode").getString(0);

                // Decode HTML entity (e.g., &#128512;) to emoji character
                String emojiCharacter = StringEscapeUtils.unescapeHtml4(emojiHtmlCode);

                // Create JLabel for each emoji
                JLabel emojiLabel = new JLabel(emojiCharacter);
                emojiLabel.setFont(new Font("Serif", Font.PLAIN, 24)); // Set font size

                // Add emoji to panel
                panel.add(emojiLabel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
