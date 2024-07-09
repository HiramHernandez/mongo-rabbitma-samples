package com.springframework.amqp.turorials.uitls;

import java.util.List;
import java.util.Map;

public final class Utils {

    private Utils() {

    }

    /**
     * Checks if is null or empty.
     *
     * @param value the value
     * @return true, if is null or empty
     */
    public static boolean isNullOrEmpty(Object value) {

        boolean result = false;

        if (value == null) {

            result = true;

        } else if (value instanceof String) {

            result = "".equals(((String) value).trim());

        } else if (value instanceof List<?>) {

            List<?> list = (List<?>) value;

            result = list.isEmpty();

        } else if (value instanceof Map<?, ?>) {

            Map<?, ?> map = (Map<?, ?>) value;

            result = map.isEmpty();

        } else if (value instanceof Object[]) {

            Object[] array = (Object[]) value;

            result = array.length == 0;

        }

        return result;

    }

}
