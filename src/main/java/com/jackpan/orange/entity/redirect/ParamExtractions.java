package com.jackpan.orange.entity.redirect;


import com.jackpan.orange.constant.VariableMatchType;

public class ParamExtractions {

    private String type;

    private String name;


    public ParamExtractions() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ParamExtractions(VariableMatchType type, String name) {
        this.type = type.getType();
        this.name = name;
    }

    public static ParamExtractions.ParamExtractionsBuilder builder() {
        return new ParamExtractions.ParamExtractionsBuilder();
    }

    public static class ParamExtractionsBuilder {
        private VariableMatchType type;
        private String name;

        ParamExtractionsBuilder() {
        }

        public ParamExtractions.ParamExtractionsBuilder type(VariableMatchType type) {
            this.type = type;
            return this;
        }

        public ParamExtractions.ParamExtractionsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ParamExtractions build() {
            return new ParamExtractions(this.type, this.name);
        }

        public String toString() {
            return "ParamExtractions.ParamExtractionsBuilder(type=" + this.type + ", name=" + this.name + ")";
        }
    }
}
