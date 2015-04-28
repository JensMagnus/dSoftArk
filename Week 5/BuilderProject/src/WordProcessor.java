class WordProcessor {
	private String section = "The Builder Pattern";
	private String subSection1 = "Intent";
	private String paragraph1 = 
			"Separate the construction of a complex object\n"+
    		"from its representation so that the same construction\n"+
    		"process can create different representations.";
	private String subSection2 = "Problem";
	private String paragraph2 = "(The problem goes here)";

	public void construct(Builder builder) {
		builder.buildSection(section);
		builder.buildSubsection(subSection1);
		builder.buildParagraph(paragraph1);
		builder.buildSubsection(subSection2);
		builder.buildParagraph(paragraph2);
	}
}    