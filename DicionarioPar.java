public class DicionarioPar<K,V> implements DicionarioInterface<K,V> {

  private Vetor<Par<K,V>> pares;

  public DicionarioPar() {
    pares = new Vetor<>();
  }

  public void add(K chave, V valor) {
    pares.adicionar(new Par(chave, valor));
  }

  public V get(K chave) {
    for(int i = 0; i < pares.tamanho(); i++) {
      Par<K,V> par = pares.buscar(i);
      if(par.getChave().equals(chave)) {
        return par.getValor();
      }
    }
    return null;
  }

}
