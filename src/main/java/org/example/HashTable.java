package org.example;

public class HashTable {
    private class Entity{
        public int key;
        public Student value;
        public Entity(int key, Student value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entity entity = (Entity) o;
            return entity.key == key;
        }
    }
    private Entity[] entities;
    private int size;
    public HashTable(int size) {
        this.entities = new Entity[size];
        this.size = size;
    }
    private int hash(int key) {
        return key % size;
    }
    public void put(Student value) {
        int index = hash(value.getId());
        if(entities[index] == null) {
            entities[index] = new Entity(value.getId(), value);
        }
        else {//колізія
            collision(value,index);
        }
    }
    private void collision(Student value, int index) {
        Entity valueToAdd = new Entity(value.getId(), value);
        for (int i = 0; i < size; i++) {
            int newIndex = (index+i) % size;
            if(entities[newIndex]==null) {
                entities[newIndex] = valueToAdd;
                return;
            }
            if(entities[newIndex].equals(valueToAdd)) {
                System.out.println("Key was added to the HashTable!");
                return;
            }
        }

    }
}
