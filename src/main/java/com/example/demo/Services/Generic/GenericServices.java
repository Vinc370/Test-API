package com.example.demo.Services.Generic;

import java.util.List;

public interface GenericServices<T> {
    public Boolean Insert(T model);
    public Boolean Update(T model);
    public Boolean Delete(int model);
    public T Get(int model);
    public List<T> getAll();
}
