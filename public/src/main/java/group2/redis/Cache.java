package group2.redis;

// 封装reids

public interface Cache<T> {

    void put(Object key, T value, int time);

    T get(Object key);

    void remove(Object key);
}
