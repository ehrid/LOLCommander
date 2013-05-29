package com.leagueoflegendscommander.objects;

import java.io.Serializable;

public class Player implements Serializable{
	private static final long serialVersionUID = -567698286377935625L;

	public String name;
	
	public int level = 1;
	
	public int drawablePlayer;
	public int drawableUlti;
	public int drawableSpell1;
	public int drawableSpell2;
	public int drawableSkill1;
	public int drawableSkill2;
	public int drawableSkill3;
	
	public int cdSpell1;
	public int cdSpell2;
	
	public int[] cdUlti;
	public int[] cdSkill1;
	public int[] cdSkill2;
	public int[] cdSkill3;
	
	public int CDR = 0;
	
	public int getCdUlti(){
		return cdUlti[level - 1]*(1-CDR);
	}
	public int getCdSkill1(){
		return cdSkill1[level - 1]*(1-CDR);
	}
	public int getCdSkill2(){
		return cdSkill2[level - 1]*(1-CDR);
	}
	public int getCdSkill3(){
		return cdSkill3[level - 1]*(1-CDR);
	}

	
	public void setPlayer(String name, int drawablePlayer, int drawableUlti, int drawableSkill1,
			int drawableSkill2, int drawableSkill3, int[] cdUlti,
			int[] cdSkill1, int[] cdSkill2, int[] cdSkill3) {
		this.name = name;
		this.drawablePlayer = drawablePlayer;
		this.drawableUlti = drawableUlti;
		this.drawableSkill1 = drawableSkill1;
		this.drawableSkill2 = drawableSkill2;
		this.drawableSkill3 = drawableSkill3;
		this.cdUlti = cdUlti;
		this.cdSkill1 = cdSkill1;
		this.cdSkill2 = cdSkill2;
		this.cdSkill3 = cdSkill3;
	}
}
