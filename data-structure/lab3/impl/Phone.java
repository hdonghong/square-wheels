package impl;

import java.util.Random;

/**
 * Phone class<br/>
 * （3）	使用3个队列分别保留手机最近10个“未接来电”、“已接来电”、“以拨电话”。
 * @author hdonghong
 * @date 2018/05/07
 */
public class Phone {

    /** 未接来电 */
    private Queue<String> missedCalls;

    /** 已接来电 */
    private Queue<String> receivedCalls;

    /** 已拨电话 */
    private Queue<String> dialedCalls;

    private static final int PHONE_NUMBER_ROUND = 10;

    public Phone() {
        missedCalls = new QByCircSinglyLinkedList<>();
        receivedCalls = new QByCircSinglyLinkedList<>();
        dialedCalls = new QByCircSinglyLinkedList<>();
    }

    /** 来电，随机生成电话号码 */
    public String rings() {
        StringBuilder phoneNumber = new StringBuilder("1");
        Random random = new Random();
        for (int i = 0; i < PHONE_NUMBER_ROUND; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    /** 拒接，加入未接来电队列 */
    public void refuse(String phoneNumber) {
        missedCalls.add(phoneNumber);
    }

    /** 接电话，加入已接来电 */
    public void receive(String phoneNumber) {
        receivedCalls.add(phoneNumber);
    }

    /** 打电话，加入已拨电话 */
    public void call(String phoneNumber) {
        dialedCalls.add(phoneNumber);
    }

    /** 查看未接来电 */
    public String showMissedCalls() {
        StringBuilder result = new StringBuilder("[未接来电]\n");
        return result.append(missedCalls).toString();
    }

    /** 查看已接来电 */
    public String showReceivedCalls() {
        StringBuilder result = new StringBuilder("[已接来电]\n");
        return result.append(receivedCalls).toString();
    }

    /** 查看已拨电话 */
    public String showDialedCalls() {
        StringBuilder result = new StringBuilder("[已拨来电]\n");
        return result.append(dialedCalls).toString();
    }
}
