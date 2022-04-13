package com.jackpan.orange.entity.rewrite;

import com.jackpan.orange.constant.VariableExtractionType;
import lombok.Builder;

import java.util.List;

@Builder
public class ParamExtractor {

    private int type;

    private List<ParamExtractions> extractions;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ParamExtractions> getExtractions() {
        return extractions;
    }

    public void setExtractions(List<ParamExtractions> extractions) {
        this.extractions = extractions;
    }

    public ParamExtractor() {
    }

    ParamExtractor(VariableExtractionType type, List<ParamExtractions> extractions) {
        this.type = type.getType();
        this.extractions = extractions;
    }

    public static ParamExtractor.ParamExtractorBuilder builder() {
        return new ParamExtractor.ParamExtractorBuilder();
    }

    public static class ParamExtractorBuilder {
        private VariableExtractionType type;
        private List<ParamExtractions> extractions;

        ParamExtractorBuilder() {
        }

        public ParamExtractor.ParamExtractorBuilder type(VariableExtractionType type) {
            this.type = type;
            return this;
        }

        public ParamExtractor.ParamExtractorBuilder extractions(List<ParamExtractions> extractions) {
            this.extractions = extractions;
            return this;
        }

        public ParamExtractor build() {
            return new ParamExtractor(this.type, this.extractions);
        }

        public String toString() {
            return "ParamExtractor.ParamExtractorBuilder(type=" + this.type + ", extractions=" + this.extractions + ")";
        }
    }
}
