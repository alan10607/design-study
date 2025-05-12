package com.alan.design.structural.bridge_pattern;

import com.alan.design.structural.bridge_pattern.abstraction.HighPriorityNotificationService;
import com.alan.design.structural.bridge_pattern.abstraction.NormalNotificationService;
import com.alan.design.structural.bridge_pattern.abstraction.NotificationService;
import com.alan.design.structural.bridge_pattern.implementator.EmailSender;
import com.alan.design.structural.bridge_pattern.implementator.SMSSender;
import com.alan.design.structural.bridge_pattern.implementator.WebSender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgePatternTest {

    @Test
    void testNotify() {
        String testBody = "test123";
        NotificationService normalEmailNotificationService = new NormalNotificationService(new EmailSender());
        NotificationService highPriorityEmailNotificationService = new HighPriorityNotificationService(new EmailSender());
        NotificationService normalSNSNotificationService = new NormalNotificationService(new SMSSender());
        NotificationService highPrioritySNSNotificationService = new HighPriorityNotificationService(new SMSSender());
        NotificationService normalWebNotificationService = new NormalNotificationService(new WebSender());
        NotificationService highPriorityWebNotificationService = new HighPriorityNotificationService(new WebSender());

        assertEquals(normalEmailNotificationService.notify(testBody), "Email message: level=NORMAL, body=" + testBody);
        assertEquals(highPriorityEmailNotificationService.notify(testBody), "Email message: level=HIGH_PRIORITY, body=" + testBody);
        assertEquals(normalSNSNotificationService.notify(testBody), "SMS message: level=NORMAL, body=" + testBody);
        assertEquals(highPrioritySNSNotificationService.notify(testBody), "SMS message: level=HIGH_PRIORITY, body=" + testBody);
        assertEquals(normalWebNotificationService.notify(testBody), "Web message: level=NORMAL, body=" + testBody);
        assertEquals(highPriorityWebNotificationService.notify(testBody), "Web message: level=HIGH_PRIORITY, body=" + testBody);
    }
}