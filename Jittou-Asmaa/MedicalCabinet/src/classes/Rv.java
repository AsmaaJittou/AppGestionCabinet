package classes;

import java.util.Date;

public class Rv {
private int id;
private Date jour;
private int id_client;
private int id_creneau;
public Rv(int id, Date jour, int id_client, int id_creneau) {
	super();
	this.id = id;
	this.jour = jour;
	this.id_client = id_client;
	this.id_creneau = id_creneau;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getJour() {
	return jour;
}
public void setJour(Date jour) {
	this.jour = jour;
}
public int getId_client() {
	return id_client;
}
public void setId_client(int id_client) {
	this.id_client = id_client;
}
public int getId_creneau() {
	return id_creneau;
}
public void setId_creneau(int id_creneau) {
	this.id_creneau = id_creneau;
}

}
