/*
 * ModeShape (http://www.modeshape.org)
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * See the AUTHORS.txt file in the distribution for a full listing of 
 * individual contributors.
 *
 * ModeShape is free software. Unless otherwise indicated, all code in ModeShape
 * is licensed to you under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * ModeShape is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.modeshape.jcr.cache.change;

import java.util.Map;

import org.modeshape.jcr.cache.NodeKey;
import org.modeshape.jcr.value.Path;
import org.modeshape.jcr.value.PathFactory;
import org.modeshape.jcr.value.ValueFactory;

/**
 * Abstract base class for all internal events.
 */
public abstract class AbstractNodeMovedChange extends AbstractNodeChange {

    private static final long serialVersionUID = 1L;

    /**
     * The keys which provide extra information in case of a move
     */
    public static final String MOVE_FROM_KEY = "srcAbsPath";
    public static final String MOVE_TO_KEY = "destAbsPath";

    /**
     * The keys which provide extra information in case of a reorder
     */
    public static final String ORDER_DEST_KEY = "destChildRelPath";
    public static final String ORDER_SRC_KEY = "srcChildRelPath";

    protected AbstractNodeMovedChange( NodeKey key,
                                       Path path ) {
        super(key, path);
    }

    /**
     * Get the old path for the node, if it is known
     * 
     * @return the old path; may be null if it is not known
     */
    public abstract Path getOldPath(PathFactory paths);

    /**
     * Return a map of additional information to be passed along in Events
     * @param stringFactory
     * @param oldPath
     * @param newPath
     * @return Map<String, String>
     */
    public abstract Map<String, String> getJcrEventInfo(ValueFactory<String> stringFactory, Path oldPath, Path newPath);
}
