/**
 * Copyright 2017 The Java2TypeScript Authors.  All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package java2typescript.helper;

import com.google.common.collect.Sets;
import java2typescript.context.TranslationContext;

import java.util.Set;

public class KeywordHelper {

    public static final Set<String> reservedWords = Sets.newHashSet(
            "let", "var", "debugger", "constructor", "yield", "export", "with", "function", "typeof", "in");

    public static String process(String name, TranslationContext ctx) {
        if (reservedWords.contains(name)) {
            throw new IllegalArgumentException("Name \""+name+"\" in " + PathHelper.lastPart(ctx) +
                    " should not use TypeScript reserved keywords: " + reservedWords.toString());
        }
        return name;
    }
}