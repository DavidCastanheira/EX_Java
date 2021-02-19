interface DicionarioInterface<K,V> {
  void add(K chave, V valor);
  V get(K chave);
}
