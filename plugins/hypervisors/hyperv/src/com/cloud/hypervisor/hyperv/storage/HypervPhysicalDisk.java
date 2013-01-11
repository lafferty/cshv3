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

public class HypervPhysicalDisk {
	
	// Path does not include the filename, which is given by the 'name' parameter.
    private String path;
    private String name;
    private HypervStoragePool pool;

    public static enum PhysicalDiskFormat {
        VHD("vhd"), VHDX("vhdx");
        String format;

        private PhysicalDiskFormat(String format) {
            this.format = format;
        }

        public String toString() {
            return this.format;
        }
    }

    private PhysicalDiskFormat format;
    private long size;
    private long virtualSize;

    public HypervPhysicalDisk(String path, String name, HypervStoragePool pool) {
        this.path = path;
        this.name = name;
        this.pool = pool;
    }

    public void setFormat(PhysicalDiskFormat format) {
        this.format = format;
    }

    public PhysicalDiskFormat getFormat() {
        return this.format;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return this.size;
    }

    public void setVirtualSize(long size) {
        this.virtualSize = size;
    }

    public long getVirtualSize() {
        return this.virtualSize;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public HypervStoragePool getPool() {
        return this.pool;
    }
}