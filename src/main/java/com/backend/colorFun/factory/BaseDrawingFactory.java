package com.backend.colorFun.factory;

import com.backend.colorFun.model.Drawing;

/**
 * Factory Method base: cada implementación provee un nivel y cómo crear el dibujo.
 */
public abstract class BaseDrawingFactory {
    /** Identificador del nivel que atiende esta factory, p.ej. "easy", "medium", "hard". */
    public abstract String level();

    /** Crea un dibujo para este nivel. */
    public abstract Drawing create(String id);
}
