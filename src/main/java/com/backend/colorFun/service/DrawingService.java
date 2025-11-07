package com.backend.colorFun.service;

import com.backend.colorFun.decorator.GlowDecorator;
import com.backend.colorFun.decorator.GuideDecorator;
import com.backend.colorFun.factory.BaseDrawingFactory;
import com.backend.colorFun.model.Drawing;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import java.util.UUID;

@Service
public class DrawingService {

    private final List<BaseDrawingFactory> factories;

    @Autowired
    public DrawingService(List<BaseDrawingFactory> factories) {
        this.factories = factories;
    }

    public Drawing get(String level, boolean guide, boolean glow) {
        BaseDrawingFactory factory = chooseFactory(level);
        Drawing drawing = factory.create(UUID.randomUUID().toString());

        String svg = drawing.getSvgContent();
        // Aplicación combinable de decoradores: orden determinístico
        if (guide) {
            svg = new GuideDecorator().decorate(svg);
        }
        if (glow) {
            svg = new GlowDecorator().decorate(svg);
        }

        drawing.setSvgContent(svg);
        return drawing;
    }

    private BaseDrawingFactory chooseFactory(String level) {
        if (level == null || level.isBlank()) level = "easy";
        final String normalized = level.toLowerCase();
        return factories.stream()
                .filter(f -> f.level().equalsIgnoreCase(normalized))
                .findFirst()
                .orElseGet(() -> factories.stream()
                        .filter(f -> f.level().equalsIgnoreCase("easy"))
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("No hay factory para nivel: " + normalized)));
    }
}
