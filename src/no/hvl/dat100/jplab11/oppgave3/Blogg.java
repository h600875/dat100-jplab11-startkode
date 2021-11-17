package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	Innlegg[] innleggstabell;
	int nesteLedig;

	public Blogg() {
		this.innleggstabell = new Innlegg[20];
		nesteLedig = 0;
	}

	public Blogg(int lengde) {
		this.innleggstabell = new Innlegg[lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggstabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for(int i = 0; i < nesteLedig; i++) {
				if(getSamling()[i].erLik(innlegg)) {
					return i;
				}
			}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for(int i = 0; i < nesteLedig; i++) {
				if(getSamling()[i].erLik(innlegg)) {
					return true;
				}
		}
		return false;
	}

	public boolean ledigPlass() {
		for(int i = 0; i < getSamling().length; i++) {
			if(getSamling()[i] == null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(!finnes(innlegg)) {
			if(ledigPlass()) {
				getSamling()[nesteLedig] = innlegg;
				nesteLedig++;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String retur = "";
			for(int i = 0; i < nesteLedig; i++) {
				retur += getSamling()[i].toString();
			}
		return nesteLedig + "\n" + retur;
	}
}