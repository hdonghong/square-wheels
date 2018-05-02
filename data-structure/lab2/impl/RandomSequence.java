package impl;

import java.util.Random;

/**
 * RandomSequence class<br/>
 *
 * 10）有效管理一个1~n的随机数序列，要求生成初始序列，保证序列中的元素值不重复，
 * 当增加或删除一个元素的时候，使序列元素值动态更新。例如，一个MP3播放器使用速记
 * 方式播放10首歌曲，曲目播放次序就是由1~10组成的一个随机数序列，当增加或删除一
 * 首歌的时候，要及时更新序列中元素值，不重复播放 <br/>
 *
 * @author hdonghong
 * @date 2018/05/02
 */
public class RandomSequence {

    public static LList<Integer> getRandomSequence (int range) {
        LList<Integer> result = new CircSinglyLinkedList<>();
        Random random = new Random();
        for (int i = 0; i < range; i++) {
            int value = 0;
            while (result.contains(value = 1 + random.nextInt(range))) {}
            result.insert(value);
        }

        return result;
    }
}
