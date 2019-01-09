/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pgasync.impl.message.backend;

import com.github.pgasync.impl.message.Message;

/**
 * @author  Antti Laisi
 */
public class CommandComplete implements Message {

    private final int affectedRows;

    public CommandComplete(String tag) {
        if (tag.contains("INSERT") || tag.contains("UPDATE") || tag.contains("DELETE")) {
            String[] parts = tag.split(" ");
            affectedRows = Integer.parseInt(parts[parts.length - 1]);
        } else {
            affectedRows = 0;
        }
    }

    public int getAffectedRows() {
        return affectedRows;
    }

    @Override
    public String toString() {
        return String.format("CommandComplete(affectedRows=%d)", affectedRows);
    }
}
