package model;

public class Lembrete {
    private int id;
    private String dataHora;
    private int anotacao;

    public Lembrete() {}

    public Lembrete(String dataHora, int anotacao) {
        this.dataHora = dataHora;
        this.anotacao = anotacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public int getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(int anotacao) {
        this.anotacao = anotacao;
    }

    @Override
    public String toString() {
        return "Lembrete{" +
                "id=" + id +
                ", dataHora='" + dataHora + '\'' +
                ", anotacao=" + anotacao +
                '}';
    }
}
