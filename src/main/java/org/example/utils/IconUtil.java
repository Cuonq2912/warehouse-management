package org.example.utils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class IconUtil {

    private static final String LOGO_PATH = "/image/logo.png";
    private static ImageIcon applicationIcon;

    public static ImageIcon getApplicationIcon() {
        if (applicationIcon == null) {
            try {
                URL iconURL = IconUtil.class.getResource(LOGO_PATH);
                applicationIcon = new ImageIcon(iconURL);

            } catch (Exception e) {
                System.err.println("Error loading logo: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return applicationIcon;
    }

    public static Image getApplicationImage() {
        ImageIcon icon = getApplicationIcon();
        return icon != null ? icon.getImage() : null;
    }

    public static void setFrameIcon(JFrame frame) {
        Image icon = getApplicationImage();
        if (icon != null) {
            frame.setIconImage(icon);
        }
    }

    public static void setDialogIcon(JDialog dialog) {
        Image icon = getApplicationImage();
        if (icon != null) {
            dialog.setIconImage(icon);
        }
    }

    public static ImageIcon getScaledIcon(int width, int height) {
        ImageIcon originalIcon = getApplicationIcon();
        if (originalIcon != null) {
            Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        }
        return null;
    }
}
