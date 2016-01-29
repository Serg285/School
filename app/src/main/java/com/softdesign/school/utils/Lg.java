package com.softdesign.school.utils;

import android.util.Log;

/**
 * Логер на основе стандартного класса.
 * Исспользует различные уровни вывода логов (Verbose, debug, info, error, warn, assert ).
 * Добавляет префикс в тег.
 * Позволяет форматировать сообщение.
 */

public class Lg {

    /**
     * Префикс сообщений в логе.
     */
    private static final String PREFIX = "SCHOOL ";

    /**
     * Максимальная длина сообщения которое нужно залогировать
     */
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    private static boolean shouldLog() {
        //TODO: Пока не используется доделать позже (нет конфига)
        // return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        // return true;
        return true;
    }

    /**
     * Отправляет в лог сообщение с уровнем VERBOSE
     * @param tag источник сообщения
     * @param text сообщение
     */
    public static void v (String tag,String text) {
        obertka(Log.VERBOSE,tag,text);
    }

    /**
     * Отправляет в лог сообщение с уровнем DEBUG
     * @param tag источник сообщения
     * @param text сообщение
     */
    public static void d (String tag,String text) {
        obertka(Log.DEBUG,tag,text);
    }

    /**
     * Отправляет в лог сообщение с уровнем INFO
     * @param tag источник сообщения
     * @param text сообщение
     */
    public static void i (String tag,String text) {
        obertka(Log.INFO,tag,text);
    }
    /**
     * Отправляет в лог сообщение с уровнем WARN
     * @param tag источник сообщения
     * @param text сообщение
     */
    public static void w (String tag,String text) {
        obertka(Log.WARN,tag,text);
    }

    /**
     * Отправляет в лог сообщение с уровнем ERROR
     * @param tag источник сообщения
     * @param text сообщение
     */
    public static void e (String tag,String text) {
        obertka(Log.ERROR,tag,text);
    }

    /**
     * Отправляет в лог сообщение с уровнем ASSERT
     * @param tag источник сообщения
     * @param text сообщение
     */
    public static void a (String tag,String text) {
        obertka(Log.ASSERT,tag,text);
    }

    /**
     * Вызывает метод класа android.utils.Log в зависимости от приоритета
     * @param  level уровень приоритета (Verbose, debug, info, error, warn, assert )
     * @param tag источник сообщения
     * @param text сообщение
     */
    public static void logger (Integer level,String tag, String text){
        switch (level) {
            case Log.VERBOSE:
                Log.v(tag,text);
                break;
            case Log.DEBUG:
                Log.d(tag, text);
                break;
            case Log.INFO:
                Log.i(tag, text);
                break;
            case Log.WARN:
                Log.w(tag, text);
                break;
            case Log.ERROR:
                Log.e(tag, text);
                break;
            case Log.ASSERT:
                Log.println(Log.ASSERT, tag, text);
                break;
        }
    }

    /**
     * Проверяет чтобы длина сообщения не превышала LOGCAT_BUFFER_SIZE
     * Запускает метод log.
     * @param level уровень приоритета (константа из Log.java)
     * @param tag источник сообщения
     * @param text сообщение
     */
    public static void obertka (Integer level, String tag, String text){
        if (shouldLog()) {
                if (text.length()> LOGCAT_BUFFER_SIZE) {
                    while (text.length()> LOGCAT_BUFFER_SIZE) {
                        text = text.substring(0, LOGCAT_BUFFER_SIZE);
                        logger(level, PREFIX + tag, text);
                    }
                } else {logger(level, PREFIX + tag, text);}
        }
    }

}
