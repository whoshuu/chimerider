package com.example.chimerider.information;

import java.util.ArrayList;
import java.util.List;

public class CUser {

	public class CFielsd {
		public String mName;
		public String mValue;
	}
	
	public enum gender {
		femenine {
			@Override
			public String getDescription() {
				return "femenine";
			}
		},
		masculine {
			@Override
			public String getDescription() {
				return "masculine";
			}
		};		
		public abstract String getDescription();
	};
	
	// TODO Rolan add the image thing around here!!
	
	public String mName;
	public int mId;
	public gender mGender;
	
	public List<CFielsd> mFields = new ArrayList<CFielsd>();
	
}
