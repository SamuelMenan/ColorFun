package com.backend.colorFun.decorator;

public class GuideDecorator extends SvgDecorator {
    @Override
    public String decorate(String svg) {
        // Usamos !important para asegurar que sobreescribe estilos previos definidos en el SVG base
        String style = "<style>.region{stroke:#ff7b00 !important; stroke-width:2 !important; opacity:0.95}</style>";
        // Insertamos tras la etiqueta <svg ...>
        return svg.replaceFirst("(?i)<svg([^>]*)>", "<svg$1>" + style);
    }
}
