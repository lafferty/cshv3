// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.hypervisor.hyperv.storage;

import java.util.List;

import com.cloud.hypervisor.hyperv.storage.HypervPhysicalDisk.PhysicalDiskFormat;
import com.cloud.storage.Storage.StoragePoolType;

public interface StorageAdaptor {

    public HypervStoragePool getStoragePool(String uuid);

    public HypervPhysicalDisk getPhysicalDisk(String volumeUuid,
            HypervStoragePool pool);

    public HypervStoragePool createStoragePool(String name, String host, int port,
            String path, String userInfo, StoragePoolType type);

    public boolean deleteStoragePool(String uuid);

    public boolean deleteStoragePool(String uuid, String localPath);

    public HypervPhysicalDisk createPhysicalDisk(String name, HypervStoragePool pool,
            PhysicalDiskFormat format, long size);

    public boolean deletePhysicalDisk(String uuid, HypervStoragePool pool);

    public HypervPhysicalDisk createDiskFromTemplate(HypervPhysicalDisk template,
            String name, PhysicalDiskFormat format, long size,
            HypervStoragePool destPool);

    public HypervPhysicalDisk createTemplateFromDisk(HypervPhysicalDisk disk,
            String name, PhysicalDiskFormat format, long size,
            HypervStoragePool destPool);

    public List<HypervPhysicalDisk> listPhysicalDisks(String storagePoolUuid,
            HypervStoragePool pool);

    public HypervPhysicalDisk copyPhysicalDisk(HypervPhysicalDisk disk, String name,
            HypervStoragePool destPools);

    public HypervPhysicalDisk createDiskFromSnapshot(HypervPhysicalDisk snapshot,
            String snapshotName, String name, HypervStoragePool destPool);

    public HypervStoragePool getStoragePoolByURI(String uri);

    public HypervPhysicalDisk getPhysicalDiskFromURI(String uri);

    public boolean refresh(HypervStoragePool pool);

    public boolean deleteStoragePool(HypervStoragePool pool);

    public boolean createFolder(String uuid, String path);

    public boolean deleteVbdByPath(String path);

}
