package org.nomanspace.Entity;

import java.util.Objects;
import java.util.UUID;

public abstract class Entity {
    private final UUID id;

    public Entity() {
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity entity)) return false;
        return id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public abstract String getAvatar();

}
