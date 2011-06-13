/*
 * This file is part of the Illarion Download Manager.
 * 
 * The Illarion Download Manager is free software: you can redistribute i and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * The Illarion Download Manager is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * the Illarion Download Manager. If not, see <http://www.gnu.org/licenses/>.
 */
package illarion.download.install.resources.dev;

import java.io.File;

import illarion.common.util.DirectoryManager;

import illarion.download.install.resources.ResourceDirectory;

/**
 * The resource directory for the development resources.
 * 
 * @author Martin Karing
 * @since 1.00
 * @version 1.00
 */
public final class DevelopmentResourceDirectory implements ResourceDirectory {
    /**
     * This is the singleton instance of this class.
     */
    private static final DevelopmentResourceDirectory INSTANCE =
        new DevelopmentResourceDirectory();

    /**
     * The directory that will be exposed to the development resources.
     */
    private String dir;

    /**
     * Private constructor to ensure that no instances but the singleton
     * instance are created. Also the directory exposed by this directory
     * handler is created here.
     */
    @SuppressWarnings("nls")
    private DevelopmentResourceDirectory() {
        final String extDir =
            System.getProperty("illarion.download.devres.dir");
        if (extDir != null) {
            dir = extDir;
        } else {
            dir =
                DirectoryManager.getInstance().getDataDirectory()
                    .getAbsolutePath()
                    + File.separator + DevelopmentResource.LOCAL_LIB_PATH;
        }
    }

    /**
     * Get the singleton instance of this class.
     * 
     * @return the singleton instance of this class
     */
    public static DevelopmentResourceDirectory getInstance() {
        return INSTANCE;
    }

    /**
     * Fetch the directory that is needed for the development resources.
     */
    @Override
    public String getDirectory() {
        return dir;
    }

}
