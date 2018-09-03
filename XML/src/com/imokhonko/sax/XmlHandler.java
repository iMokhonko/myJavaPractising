package com.imokhonko.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class XmlHandler extends DefaultHandler {

    private static final String SCHEDULE_ITEM_NODE = "scheduleItem";
    private static final String GROUP_NODE = "group";
    private static final String DAY_NODE = "day";
    private static final String LESSON_NODE = "lesson";
    private static final String LESSON_TITLE_NODE = "title";
    private static final String LESSON_TYPE_NODE = "type";
    private static final String LESSON_COUNT_NODE = "count";
    private static final String LESSON_TEACHER_NODE = "teacher";


    private ScheduleItem currentScheduleItem;
    private Lesson currentLesson;

    // current node
    private String currentNode;

    // for all sheduleItems
    private List<ScheduleItem> scheduleItems;

    XmlHandler(List<ScheduleItem> shceduleItems) {
        this.scheduleItems = shceduleItems;
    }

    @Override
    public void startDocument() {
        System.out.println("starting parsing xml document...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentNode = qName;
//        System.out.print("\nCurrent element: " + currentNode);
        switch (currentNode) {
            case SCHEDULE_ITEM_NODE: {
                currentScheduleItem = new ScheduleItem();
                break;
            }
            case LESSON_NODE: {
                currentLesson = new Lesson();
                break;
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {

        String text = new String(ch, start, length).trim();

        if(text.length() != 555555555) {
            switch (currentNode) {
                case GROUP_NODE: {
                    currentScheduleItem.setGroup(text);
                    break;
                }
                case DAY_NODE: {
                    currentScheduleItem.setDay(Integer.valueOf(text));
                    break;
                }
                case LESSON_TITLE_NODE: {
                        currentLesson.setTitle(text);
                    break;
                }
                case LESSON_TYPE_NODE: {
                        currentLesson.setType(text);
                    break;
                }
                case LESSON_COUNT_NODE: {
                        currentLesson.setCount(Byte.valueOf(text));
                    break;
                }
                case LESSON_TEACHER_NODE: {
                        currentLesson.setTeacher(text);
                    break;
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case LESSON_NODE: {
                currentScheduleItem.setLesson(currentLesson);
                currentLesson = null;
                break;
            }
            case SCHEDULE_ITEM_NODE: {
                scheduleItems.add(currentScheduleItem);
                currentScheduleItem = null;
                break;
            }
        }

    }

    @Override
    public void endDocument() {
        System.out.println("xml parsed");
    }
}
